package com.qingting.customer.controller.admin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.qingting.customer.baseserver.AreaService;
import com.qingting.customer.baseserver.CityService;
import com.qingting.customer.baseserver.ProvinceService;
import com.qingting.customer.common.pojo.hbasedo.Area;
import com.qingting.customer.common.pojo.hbasedo.City;
import com.qingting.customer.common.pojo.hbasedo.Province;
import com.smart.mvc.model.ResultCode;
import com.smart.mvc.model.WebResult;
import com.smart.mvc.util.StringUtils;
import com.smart.mvc.validator.Validator;
import com.smart.mvc.validator.annotation.ValidateParam;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "地址管理")
@Controller
@RequestMapping("/admin/addr")
public class AddrController {
	@Resource
	ProvinceService provinceService;
	@Resource
	CityService cityService;
	@Resource
	AreaService areaService;
	
	@ApiOperation("地址管理-页面跳转省页")
	@RequestMapping(value="/province",method = RequestMethod.GET)
	public String province(){
		return "/admin/addr/province";
	}
	@ApiOperation("地址管理-页面跳转市页")
	@RequestMapping(value="/city",method = RequestMethod.GET)
	public String city(){
		return "/admin/addr/city";
	}
	@ApiOperation("地址管理-页面跳转区页")
	@RequestMapping(value="/area",method = RequestMethod.GET)
	public String area(){
		return "/admin/addr/area";
	}
	@ApiOperation("按文本文件插入省市区")
	@RequestMapping(value = "/insertBytxt", method = RequestMethod.POST)
	public @ResponseBody WebResult<String> insertBytxt(MultipartFile file){
		InputStream is=null;//字节流
		InputStreamReader isr=null;//将字节转换到字符的输入流
		BufferedReader br=null;//缓冲输入字符流
		
		int line = 1;
		List<Province> pros=new ArrayList<Province>();
		List<City> citys=new ArrayList<City>();
		List<Area> areas=new ArrayList<Area>();
		byte proId=1;
		short cityId=1;
		short areaId=1;
		try {
			is = file.getInputStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			String str=null;
			while( (str=br.readLine())!=null ){//解析开始
				if(!StringUtils.isBlank(str)){
					//System.out.println("line " + line + ": " + str);
					
					char[] chars=str.toCharArray();
					//编码相关变量
					final int CODE_LENGTH=6;
					
					int currentCodeLength=0;
					int codeStartIndex=-1;
					boolean codeSearchSuccess=false;
					String code=null;
					//名字相关变量
					int currentNameLength=0;
					int nameStartIndex=-1;
					boolean nameSearchSuccess=false;
					String name=null;
					
					//System.out.println("chars.length:"+chars.length);
					for (int i=0;i<chars.length;i++) {
						int temp=((int)chars[i]);
						//System.out.print("temp"+i+":"+temp+"|");
						//编码在前，先找编码
						if(codeSearchSuccess==false && temp>47 && temp<58){
							if(codeStartIndex<0){//找到编码开始位置
								codeStartIndex=i;
								code=new String();
							}
							if(codeStartIndex>-1){//计数，转存
								currentCodeLength++;
								code+=chars[i];
								//System.out.print("codechar:"+chars[i]+"|");
								if(currentCodeLength==CODE_LENGTH){
									codeSearchSuccess=true;
									//System.out.println("");
								}
							}
						}else if(codeSearchSuccess==false){
							if(currentCodeLength==CODE_LENGTH){
								codeSearchSuccess=true;
								break;
							}else{
								currentCodeLength=0;
								codeStartIndex=-1;
								codeSearchSuccess=false;
								code=null;
							}
						}
						//名字在后，后找名字
						if(codeSearchSuccess==true && nameSearchSuccess==false && temp>19967 && temp<40870){
							if(nameStartIndex<0){//找到编码开始位置
								nameStartIndex=i;
								name=new String();
							}
							if(nameStartIndex>-1){//计数，转存
								currentNameLength++;
								name+=chars[i];
								//System.out.println("namechar:"+chars[i]+"|");
							}
						}else if(codeSearchSuccess==true && nameSearchSuccess==false){
							if(currentNameLength>1 && nameStartIndex>(codeStartIndex+CODE_LENGTH)){
								nameSearchSuccess=true;
								break;
							}else{
								currentNameLength=0;
								nameStartIndex=-1;
								nameSearchSuccess=false;
								name=null;
							}
						}
					}
					if(code!=null && code.length()==CODE_LENGTH && name!=null ){
						if(Pattern.matches("\\d\\d0000",code)){//省编码
							Province province=new Province();
							province.setId(proId++);
							province.setCode(code);
							province.setName(name);
							province.setCreateTime(Calendar.getInstance());
							pros.add(province);
						}else if(Pattern.matches("\\d\\d\\d\\d00",code)){//市编码
							City city=new City();
							city.setId(cityId++);
							city.setCode(code);
							city.setName(name);
							city.setProvinceCode(new StringBuffer(code).replace(2, 4, "00").toString());
							city.setCreateTime(Calendar.getInstance());
							citys.add(city);
						}else{//区编码
							Area area=new Area();
							area.setId(areaId++);
							area.setCode(code);
							area.setName(name);
							area.setCityCode(new StringBuffer(code).replace(4, 6, "00").toString());
							area.setCreateTime(Calendar.getInstance());
							areas.add(area);
						}
					}
					line++;
				}
				
			}//解析结束
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(br!=null)
				try {br.close();} catch (IOException e) {e.printStackTrace();}
			if(isr!=null)
				try {isr.close();} catch (IOException e) {e.printStackTrace();}
			if(is!=null)
				try {is.close();} catch (IOException e) {e.printStackTrace();}
		}
		for (Province province : pros) {
			System.out.println(province);
		}
		provinceService.insertProvinceList(pros);
		for (City city : citys) {
			System.out.println(city);
		}
		cityService.insertCityList(citys);
		for (Area area : areas) {
			System.out.println(area);
		}
		areaService.insertAreaList(areas);
		System.out.println("上传成功");
		System.out.println("上传文件文本["+line+"]行"+",最终解析["+(pros.size()+citys.size()+areas.size())+"]行");
		WebResult<String> result=new WebResult<String>(ResultCode.SUCCESS);
		result.setData("上传文件文本["+line+"]行"+",最终解析["+(pros.size()+citys.size()+areas.size())+"]行");
		result.setMessage("成功");
		return result;
	}
	@ApiOperation("查询所有省")
	@RequestMapping(value = "/listProvince", method = RequestMethod.GET)
	public @ResponseBody WebResult<List<Province>> listProvince(
			@ApiParam(value = "ID") Integer id,
			@ApiParam(value = "编码") String code,
			@ApiParam(value = "开始页码", required = true) @ValidateParam({ Validator.NOT_BLANK }) Integer pageNo,
			@ApiParam(value = "显示条数", required = true) @ValidateParam({ Validator.NOT_BLANK }) Integer pageSize
			){
		WebResult<List<Province>> result=new WebResult<List<Province>>(ResultCode.SUCCESS);
		if(id==null || id==0)
			id=null;
		if(StringUtils.isBlank(code))
			code=null;
		result.setData(provinceService.listProvince(id,code));
		result.setMessage("成功");
		return result;
	}
	@ApiOperation("查询所有市")
	@RequestMapping(value = "/listCity", method = RequestMethod.GET)
	public @ResponseBody WebResult<List<City>> listCity(
			@ApiParam(value = "ID") Integer id,
			@ApiParam(value = "编码") String code,
			@ApiParam(value = "开始页码", required = true) @ValidateParam({ Validator.NOT_BLANK }) Integer pageNo,
			@ApiParam(value = "显示条数", required = true) @ValidateParam({ Validator.NOT_BLANK }) Integer pageSize
			){
		WebResult<List<City>> result=new WebResult<List<City>>(ResultCode.SUCCESS);
		if(id==null || id==0)
			id=null;
		if(StringUtils.isBlank(code))
			code=null;
		result.setData(cityService.listCity(id,code));
		result.setMessage("成功");
		return result;
	}
	@ApiOperation("查询所有区")
	@RequestMapping(value = "/listArea", method = RequestMethod.GET)
	public @ResponseBody WebResult<List<Area>> listArea(
			@ApiParam(value = "ID") Integer id,
			@ApiParam(value = "编码") String code,
			@ApiParam(value = "开始页码", required = true) @ValidateParam({ Validator.NOT_BLANK }) Integer pageNo,
			@ApiParam(value = "显示条数", required = true) @ValidateParam({ Validator.NOT_BLANK }) Integer pageSize
			){
		WebResult<List<Area>> result=new WebResult<List<Area>>(ResultCode.SUCCESS);
		if(id==null || id==0)
			id=null;
		if(StringUtils.isBlank(code))
			code=null;
		result.setData(areaService.listArea(id,code));
		result.setMessage("成功");
		return result;
	}
}
