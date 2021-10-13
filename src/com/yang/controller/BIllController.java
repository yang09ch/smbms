package com.yang.controller;

import com.yang.pojo.SmbmsBill;
import com.yang.pojo.SmbmsProvider;
import com.yang.service.SmbmsBillService;
import com.yang.service.SmbmsProviderService;
import com.yang.util.PageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("bill")
public class BIllController {

    @Resource
    SmbmsBillService billService;

    @Resource
    SmbmsProviderService providerService;


    @RequestMapping("/limit")//做分页组合查询  三天条件查询
    public  String getBillLimit(
            @RequestParam(value = "queryIsPayment",required = true,defaultValue = "-1") Integer queryIsPayment,
            String queryProductName,
            @RequestParam(value = "queryProviderId",required = true,defaultValue = "-1") Integer queryProviderId,
            @RequestParam(value = "pageIndex",required = true,defaultValue = "1") Integer pageIndex, Model model){
        PageUtil<SmbmsBill> billLimit =
                billService.getBillLimit(queryIsPayment,queryProductName, queryProviderId, pageIndex, 5);
        List<SmbmsProvider> all = providerService.getAll();
        model.addAttribute("providerList",all);
        model.addAttribute("billList",billLimit);
        return "jsp/bill/billlist";
    }

    @RequestMapping("/toadd")
    public String toadd(Model model){
        List<SmbmsProvider> all = providerService.getAll();
        model.addAttribute("providerList",all);
        return "jsp/bill/billadd";
    }

    @RequestMapping("/doadd")
    public  String doadd(SmbmsBill bill){
        int insert = billService.insert(bill);
        if (insert>0){
            return "redirect:/bill/limit";
        }else{
            return "redirect:/bill/toadd";
        }
    }

    @RequestMapping("/toSelect/{id}/{index}")
    public String toSelect(@PathVariable("id") Integer id,
                           @PathVariable("index") Integer index, Model model){
        SmbmsBill byid = billService.getByid(id);
        model.addAttribute("bill",byid);
        if (index==2){
            List<SmbmsProvider> all = providerService.getAll();
            model.addAttribute("providerList",all);
            return "jsp/bill/billmodify";
        }
        return "jsp/bill/billview";

    }

    @RequestMapping("/doUpdate")
    public  String doUpdate(SmbmsBill bill){
        int update = billService.getUpdate(bill);
        if (update>0){
            return "redirect:/bill/limit";
        }
        return "redirect:/bill/toSelect/"+bill.getId()+"/2";
    }

    @RequestMapping("/dele")
    @ResponseBody
    public String delete(Integer billid){
        int delete = billService.delete(billid);
        if (delete>0){
            return "true";
        }else{
            return "false";
        }


    }

}
