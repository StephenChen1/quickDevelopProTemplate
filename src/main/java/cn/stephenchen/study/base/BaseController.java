package cn.stephenchen.study.base;

import cn.stephenchen.study.util.ConvertUtil;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @Author : chenzhulin
 * @Date : 2019/1/19 17 29
 * @Description : 基础controller，即基本的增删查改controller
 */
public abstract class BaseController<R extends BaseEntity> {


    private BaseService<R> baseService;

    public BaseService<R> getBaseService() {
        return this.baseService;
    }




    /**
     * 插入记录
     * @param r
     * @return
     */
    @RequestMapping(value = "/insert" , method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse insertMeetingRoom(@RequestBody R r){
        if(null == r){
            return JsonResponse.newError("参数不能为空");
        }
        //调用service
        Boolean success = this.getBaseService().insert(r);
        if(success){
            return JsonResponse.newOk("success!");
        }
        return JsonResponse.newError("插入记录出错");

    }


    /**
     * 根据id删除记录
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete/{id}" , method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse deleteMeetingRoomById(@PathVariable("id") Integer id){

        if(null == id){
            return JsonResponse.newError("id不能为空");
        }
        //调用service
        boolean success = this.getBaseService().deleteById(id);
        if(success){
            return JsonResponse.newOk("success!");
        }
        return JsonResponse.newError("删除出错");
    }





    /**
     * 根据id获取详情
     * @param id
     * @param request
     * @return
     */
    @RequestMapping("/{id}")
    @ResponseBody
    public JsonResponse detail(@PathVariable("id") Integer id, HttpServletRequest request) {
        //该语句决定了具体的service需要实现getBaseService()方法
        R r = this.getBaseService().selectByPrimaryKey(id);
        return JsonResponse.newOk(r);
    }


    /**
     * 根据多参数查询数据
     * @param jsonRequest
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/find")
    @ResponseBody
    public JsonResponse find(@RequestBody JsonRequest jsonRequest, HttpServletRequest request) throws Exception {


        //查询对象转换为map型参数
        Map<String , Object > paramMap = ConvertUtil.JsonRequestToMapParams(jsonRequest);
        //调用service查询得到结果
        List<R> result = this.getBaseService().find(paramMap);
        JsonResponse jsonResponse = JsonResponse.newOk(result);
        //得到除去分页参数的查询总数
        int total = this.getBaseService().count(paramMap);

        //当前页码
        Integer curPage = (null == jsonRequest.getPageNum())? 1: jsonRequest.getPageNum() ;
        if(curPage == 0){
            return JsonResponse.newError("页码不能为0");
        }
        //每页容量
        Integer pageCount = (null == jsonRequest.getPageCount()) ? 20 : jsonRequest.getPageCount();
        if(pageCount == 0){
            return JsonResponse.newError("页容量不能为0");
        }
        //当前页数据数量
        Integer curCount = (null == result) ? 0 : result.size() ;
        //设置返回值的分页信息
        Pagination pagination = Pagination.newInstance(total, curPage ,curCount ,pageCount);
        //设置返回值分页信息
        jsonResponse.setPagination(pagination);

        return jsonResponse;
    }

    /**
     * 修改记录
     * @param r
     * @return
     */
    @RequestMapping(value = "/update" , method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse updateMeetingRoom(@RequestBody R r){

        if(null == r ){
            return JsonResponse.newError("参数不能为空");
        }
        if(null == r.getId() || "".equals(r.getId().toString().trim())){
            return JsonResponse.newError("参数id不能为空");
        }
        //调用service
        boolean success = this.getBaseService().update(r);
        if(success){
            return JsonResponse.newOk("success!");
        }
        return JsonResponse.newError("更新出错");
    }




}
