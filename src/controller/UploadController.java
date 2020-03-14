package controller;

import org.apache.commons.lang.xwork.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pojo.UploadedImageFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@Controller
public class UploadController {
    /*建类UploadController 作为上传控制器
    准备方法upload 映射上传路径/uploadImage
    1. 方法的第二个参数UploadedImageFile 中已经注入好了 image
    2. 通过 RandomStringUtils.randomAlphanumeric(10);获取一个随机文件名。 因为用户可能上传相同文件名的文件，为了不覆盖原来的文件，通过随机文件名的办法来规避
    3. 根据request.getServletContext().getRealPath 获取到web目录下的image目录，用于存放上传后的文件。
    4. 调用file.getImage().transferTo(newFile); 复制文件
    5. 把生成的随机文件名提交给视图，用于后续的显示*/


    @RequestMapping("/uploadImage")
    public ModelAndView upload(HttpServletRequest request, UploadedImageFile file) throws Exception {
        String name = RandomStringUtils.randomAlphabetic(10);
        String newFileName = name + ".png";
        File newFile = new File(request.getServletContext().getRealPath("/image"),newFileName);
        newFile.getParentFile().mkdirs();
        file.getImage().transferTo(newFile);
        System.out.println("==="+request.getServletContext().getRealPath("/image"));

        ModelAndView mav = new ModelAndView("showUploadedFile");
        mav.addObject("imageName", newFile);
        return mav;
    }
}
