package com.qingting.customer.controller.consumer;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qingting.customer.common.pojo.dto.EvaDTO;
import com.qingting.customer.common.pojo.dto.HisSerSimpleDTO;
import com.qingting.customer.common.pojo.dto.HisServiceDTO;
import com.qingting.customer.common.pojo.dto.PlanDTO;
import com.smart.mvc.model.ResultCode;
import com.smart.mvc.model.WebResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "服务相关")
@Controller("consumerServiceController")
@RequestMapping("/consumer/service")
public class ServiceController {
	String[][] str={
			{"不礼貌","说脏话","爱吐槽","没素养","不喜欢","做事不认真","做完事不收拾","看不顺眼","不尊敬他人","故意拖拉"},
			{"冷嘲热讽","语言刻薄","拒人千里","一幅驴脸","冷若冰霜","面无表情","敷衍了事","草草了事","不冷不热","代答不理","视耳不闻"},
			{"善解人意","心细如发","体贴","富有爱心","温柔沉静"},
			{"思想成熟","精明能干","为人诚实"},
			{"个性稳重","具高度责任感","工作很有条理","办事效率高"}
			};
	String[] str1={"fw201706291134","fw201706291135","fw201706291136","fw201706291137",
					"fw201706291138","fw201706291139","fw201706291140","fw201706291141"};
	static Integer rank=1-1;//1星
	
	private HisSerSimpleDTO getSimpleDTO(boolean evaFlag,String serCode,Integer imageNo){
		HisSerSimpleDTO his=new HisSerSimpleDTO();
		his.setAdress("四川省成都市郫县犀浦镇樟菊园3幢2单元1201");
		
		his.setImage("/resource/images/customer/serType/type-"+imageNo+".png");
		his.setRank(rank);
		his.setSerContent("1、第一级5微米PP棉滤芯（检查或更换）2、第二级颗粒活性炭滤芯（检查或更换）3、第三级烧结活性炭滤芯（检查或更换）4、第四级RO反渗透膜（检查或更换）5、第五级后置活性炭滤芯（检查或更换）");
		his.setSerHead("原水净化服务");
	
		his.setEvaFlag(evaFlag);
		his.setTime(Calendar.getInstance());
		his.setSerCode(serCode);
		return his;
	}
	@ApiOperation("获取当前用户的所有历史服务记录")
	@RequestMapping(value="/listHis",method = RequestMethod.GET)
	public @ResponseBody WebResult<List<HisSerSimpleDTO>> listHis(){
		List<HisSerSimpleDTO> list=new ArrayList<HisSerSimpleDTO>();
		for(int i=0;i<8;i++){
			list.add(getSimpleDTO(i%2==1,str1[i],i+1));
		}
		WebResult<List<HisSerSimpleDTO>> result=new WebResult<List<HisSerSimpleDTO>>(ResultCode.SUCCESS);
		result.setData(list);
		result.setMessage("获取成功");
		return result;
	}
	private HisServiceDTO getDTO(boolean evaFlag,String serCode){
		HisServiceDTO his=new HisServiceDTO();
		his.setAdress("四川省成都市郫县犀浦镇樟菊园3幢2单元1201");
		his.setEmpCode("cdzb201701010140");
		his.setEquipName("小清渟");
		List<EvaDTO> list1=new ArrayList<EvaDTO>();
		for(int i=0;i<str[rank].length;i++){
			EvaDTO ev1=new EvaDTO();
			ev1.setFlag(str[rank].length/2>i);
			ev1.setTagName(str[rank][i]);
			list1.add(ev1);
		}
		his.setEvaContent(list1);
		List<String> list2=new ArrayList<String>();
		list2.add("/resource/images/customer/service/fw1.png");
		list2.add("/resource/images/customer/service/fw2.png");
		list2.add("/resource/images/customer/service/fw3.png");
		list2.add("/resource/images/customer/service/fw4.png");
		list2.add("/resource/images/customer/service/fw5.png");
		list2.add("/resource/images/customer/service/fw6.png");
		his.setImages(list2);
		his.setEmpName("陈应刚");
		his.setNotice(Calendar.getInstance());
		his.setPortrait("/resource/images/customer/head/cyg.png");
		his.setRank(rank);
		his.setSerContent("1、第一级5微米PP棉滤芯（检查或更换）2、第二级颗粒活性炭滤芯（检查或更换）3、第三级烧结活性炭滤芯（检查或更换）4、第四级RO反渗透膜（检查或更换）5、第五级后置活性炭滤芯（检查或更换）");
		his.setSerHead("原水净化服务");
		his.setStatus("已完成");
		his.setEvaFlag(evaFlag);
		his.setTime(Calendar.getInstance());
		his.setSerCode(serCode);
		return his;
	}
	@ApiOperation("获取当前用户的某条历史服务记录")
	@RequestMapping(value="/getHis",method = RequestMethod.GET)
	public @ResponseBody WebResult<HisServiceDTO> getHis(
			@ApiParam(value = "服务编号", required = true) @RequestParam String serCode
			){
		WebResult<HisServiceDTO> result=new WebResult<HisServiceDTO>(ResultCode.SUCCESS);
		result.setData(getDTO(true,serCode));
		result.setMessage("获取成功");
		return result;
	}
	private PlanDTO getPlanDTO(){
		PlanDTO p=new PlanDTO();
		p.setAdress("四川成都高新西区天全路222号 无线通信国家专业化众创空间2号楼8楼整层");
		p.setEquipCode("xqt201701010143");
		p.setEquipName("小清渟");
		
		List<String> list2=new ArrayList<String>();
		list2.add("/resource/images/customer/plan/fw1.png");
		list2.add("/resource/images/customer/plan/fw2.png");
		list2.add("/resource/images/customer/plan/fw3.png");
		list2.add("/resource/images/customer/plan/fw4.png");
		list2.add("/resource/images/customer/plan/fw5.png");
		list2.add("/resource/images/customer/plan/fw6.png");
		p.setImages(list2);
		
		p.setEmpName("陈应刚");
		p.setNotice(Calendar.getInstance());
		p.setPortrait("/resource/images/customer/head/cyg.png");
		p.setRemark("饮水机出水口快要脱落,需要更换.入水口螺帽有裂纹,有漏水风险,需要更换");
		p.setSerHead("原水净化服务");
		p.setStatus("待服务");
		p.setWarnContent("1、第三级烧结活性炭滤芯（检查或更换）2、第四级RO反渗透膜（检查或更换）");
		return p;
	}
	@ApiOperation("获取当前设备下次服务方案")
	@RequestMapping(value="/listPlan",method = RequestMethod.GET)
	public @ResponseBody WebResult<List<PlanDTO>> listPlan(
			@ApiParam(value = "设备编号", required = false) @RequestParam(value="equipCode", required=false) String equipCode
			){
		List<PlanDTO> list=new ArrayList<PlanDTO>();
		list.add(getPlanDTO());
		list.add(getPlanDTO());
		list.add(getPlanDTO());
		list.add(getPlanDTO());
		list.add(getPlanDTO());
		list.add(getPlanDTO());
		list.add(getPlanDTO());
		list.add(getPlanDTO());
		list.add(getPlanDTO());
		list.add(getPlanDTO());
		list.add(getPlanDTO());
		list.add(getPlanDTO());
		WebResult<List<PlanDTO>> result=new WebResult<List<PlanDTO>>(ResultCode.SUCCESS);
		result.setData(list);
		result.setMessage("获取成功");
		return result;
	}
}
