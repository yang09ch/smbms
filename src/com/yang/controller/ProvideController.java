package com.yang.controller;

import com.yang.pojo.SmbmsProvider;
import com.yang.service.SmbmsProviderService;
import com.yang.util.PageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("provide")
public class ProvideController {

    @Resource
    SmbmsProviderService ps;

    @RequestMapping("/provideLimit")
    public String provideLimit(String queryProCode, String queryProName
            , @RequestParam(value = "pageIndex",required = true,defaultValue = "1") Integer pageIndex, Model model){
             PageUtil<SmbmsProvider> limit = ps.getLimit(queryProCode, queryProName, pageIndex, 7);
            model.addAttribute("providerList",limit);
             return  "jsp/provider/providerlist";
    }

    @RequestMapping("/doadd")
    public String doadd(SmbmsProvider provider){
        int insert = ps.insert(provider);
        if (insert>0){
         return "redirect:/provide/provideLimit";
        }
        return "jsp/provider/provideradd";
    }

    //查看 + 去修改
    @RequestMapping("/toSelect/{id}/{index}")
    public String toSelect(@PathVariable("id") Integer id,@PathVariable("index") Integer index,Model model){
        SmbmsProvider byid = ps.getByid(id);
        model.addAttribute("provider",byid);
        if (index==1){
            return "jsp/provider/providerview";
        }
        return "jsp/provider/providermodify";
    }

    @RequestMapping("/doupdate")
    public  String doupdate(SmbmsProvider provider){
        int update = ps.update(provider);
        if (update>0){
            return "redirect:/provide/provideLimit";
        }
        return "redirect:/provide/toSelect/"+provider.getId()+"/2";
    }
    @RequestMapping("/delete")
    @ResponseBody
    public String dele(Integer proid){
        int delete = ps.delete(proid);
        if (delete>0){
            return "true";
        }else{
            return "false";
        }

    }
}
