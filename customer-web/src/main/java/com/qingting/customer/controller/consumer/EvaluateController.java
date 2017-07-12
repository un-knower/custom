package com.qingting.customer.controller.consumer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qingting.customer.common.pojo.dto.Evaluate;
import com.qingting.customer.common.pojo.dto.TagDTO;
import com.qingting.customer.common.pojo.hbasedo.Tag;
import com.smart.mvc.model.ResultCode;
import com.smart.mvc.model.WebResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "评价相关")
@Controller("consumerEvaluateController")
@RequestMapping("/consumer/evaluate")
public class EvaluateController {
	@ApiOperation("提交评价")
	@RequestMapping(value="/set",method = RequestMethod.POST,produces = "application/json; charset=utf-8")
	public @ResponseBody WebResult<String> setEvaluate(
			//@ApiParam(value = "等级", required = true) @RequestParam Integer rank,
			//@ApiParam(value = "标签集合数组", required = true) @RequestParam List<Integer> tags,
			//@ApiParam(value = "文本内容", required = true) @RequestParam String content,
			//@ApiParam(value = "服务编号", required = true) @RequestParam String serCode
			@ApiParam(value = "评价", required = true) @RequestBody Evaluate evaluate
			){
		WebResult<String> result=new WebResult<String>(ResultCode.SUCCESS);
		result.setMessage("提交成功");
		result.setData(evaluate.getSerCode());
		return result;
	}
	@ApiOperation("获得评价标签根据等级")
	@RequestMapping(value="/listTag",method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	public @ResponseBody WebResult<List<Tag>> listTag(
			@ApiParam(value = "等级", required = true) @RequestParam Integer rank
			){
		WebResult<List<Tag>> result=new WebResult<List<Tag>>(ResultCode.SUCCESS);
		List<Tag> list=new ArrayList<Tag>();
		Tag t1=new Tag();
		t1.setTagName("专业");
		t1.setRank(1);
		Tag t2=new Tag();
		t2.setTagName("高效");
		t2.setRank(2);
		Tag t3=new Tag();
		t3.setTagName("礼貌");
		t3.setRank(3);
		Tag t4=new Tag();
		t4.setTagName("高细心");
		t4.setRank(4);
		Tag t5=new Tag();
		t5.setTagName("专业");
		t5.setRank(5);
		Tag t6=new Tag();
		t6.setTagName("高效");
		t6.setRank(6);
		Tag t7=new Tag();
		t7.setTagName("礼貌");
		t7.setRank(7);
		Tag t8=new Tag();
		t8.setTagName("高细心");
		t8.setRank(8);
		list.add(t1);
		list.add(t2);
		list.add(t3);
		list.add(t4);
		list.add(t5);
		list.add(t6);
		list.add(t7);
		list.add(t8);
		result.setData(list); 
		result.setMessage("成功");
		return result;
	}
	public List<Tag> get(Integer rank,String[] str){
		List<Tag> arr=new ArrayList<Tag>();
		for (String string : str) {
			Tag t1=new Tag();
			t1.setTagName(string);
			t1.setRank(rank);
			arr.add(t1);
		}
		/*Tag t1=new Tag();
		t1.setTagName("专业");
		t1.setRank(1);
		Tag t2=new Tag();
		t2.setTagName("高效");
		t2.setRank(1);
		Tag t3=new Tag();
		t3.setTagName("礼貌");
		t3.setRank(1);
		Tag t4=new Tag();
		t4.setTagName("高细心");
		t4.setRank(1);
		Tag t5=new Tag();
		t5.setTagName("专业");
		t5.setRank(1);
		Tag t6=new Tag();
		t6.setTagName("高效");
		t6.setRank(1);
		Tag t7=new Tag();
		t7.setTagName("礼貌");
		t7.setRank(1);
		Tag t8=new Tag();
		t8.setTagName("高细心");
		t8.setRank(1);
		one.add(t1);
		one.add(t2);
		one.add(t3);
		one.add(t4);
		one.add(t5);
		one.add(t6);
		one.add(t7);
		one.add(t8);*/
		return arr;
	}
	@ApiOperation("获得评价标签")
	@RequestMapping(value="/listAllTag",method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	public @ResponseBody WebResult<TagDTO> listAllTag(
			){
		WebResult<TagDTO> result=new WebResult<TagDTO>(ResultCode.SUCCESS);
		TagDTO td=new TagDTO();
		String[][] str={
				{"不礼貌","说脏话","爱吐槽","没素养","不喜欢","做事不认真","做完事不收拾","看不顺眼","不尊敬他人","故意拖拉"},
				{"冷嘲热讽","语言刻薄","拒人千里","一幅驴脸","冷若冰霜","面无表情","敷衍了事","草草了事","不冷不热","代答不理","视耳不闻"},
				{"善解人意","心细如发","体贴","富有爱心","温柔沉静"},
				{"思想成熟","精明能干","为人诚实"},
				{"个性稳重","具高度责任感","工作很有条理","办事效率高"}
				};
		for(int i=1;i<6;i++){
			List<Tag> list = get(i,str[i-1]);
			if(i==1)
				td.setOne(list);
			if(i==2)
				td.setTwo(list);
			if(i==3)
				td.setThree(list);
			if(i==4)
				td.setFour(list);
			if(i==5)
				td.setFive(list);
		}
		result.setData(td); 
		result.setMessage("成功");
		return result;
	}
}
