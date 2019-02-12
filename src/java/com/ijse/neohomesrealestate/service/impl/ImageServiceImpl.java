/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.neohomesrealestate.service.impl;

import com.ijse.neohomesrealestate.dao.ImageDao;
import com.ijse.neohomesrealestate.model.Advertistment;
import com.ijse.neohomesrealestate.model.Image;
import com.ijse.neohomesrealestate.model.User;
import com.ijse.neohomesrealestate.service.ImageService;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author vinod
 */
@Service
@Transactional
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageDao imageDao;

    @Autowired
    private HttpServletRequest request;

    @Override
    public String saveImages(List<Image> images) {
        Serializable save = imageDao.save(images);

        if (save != null) {
            return "true";
        } else {
            return "Something went Wrong";
        }

    }

    @Override
    public String saveProImg(MultipartFile file, String nic) throws IOException {

        byte[] bytes = file.getBytes();
        File dir = new File("F:\\GDSE\\Projects\\Semester Projects\\Home Rental System\\Project\\NeoHomesRealEstate\\proImgs\\profile");
        File serverFile = new File(dir.getAbsolutePath() + File.separator + nic + ".jpg");
        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
        stream.write(bytes);
        stream.close();
        return serverFile.getAbsolutePath();

    }

    @Override
    public List<Image> setImagestoFolder(Advertistment lastAdv) {
        List<byte[]> multiImages = (List<byte[]>) request.getSession().getAttribute("newAdvImages");
        BufferedOutputStream stream = null;
        List<Image> newImages = new ArrayList<>();

        int count = 1;

        try {
            for (byte[] imgBytes : multiImages) {

                File dir = new File("F:\\GDSE\\Projects\\Semester Projects\\Home Rental System\\Project\\NeoHomesRealEstate\\proImgs\\adv" + File.separator + lastAdv.getAdvId());
                if (!dir.exists()) {
                    dir.mkdirs();
                }

                File serverFile = new File(dir.getAbsolutePath() + File.separator + count + ".jpg");

                stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                stream.write(imgBytes);
                stream.close();
                serverFile.getAbsolutePath();

                Image image = new Image();
                image.setAdvertistment(lastAdv);
                image.setImgPath(serverFile.getAbsolutePath());
                newImages.add(image);
                count++;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return newImages;
    }

    @Override
    public byte[] previewProImg() {

        User user = (User) request.getSession().getAttribute("loggedUser");
        FileInputStream fis = null;
        byte[] readAllBytes = null;
        try {

            File f = new File(user.getImgPath());
            fis = new FileInputStream(f);
            byte imageData[] = new byte[(int) f.length()];
            fis.read(imageData);
            readAllBytes = Base64.encodeBase64(imageData);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ImageServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ImageServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(ImageServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return readAllBytes;
    }

    @Override
    public List<Image> getAdvImages(Advertistment advertistment) {
        return imageDao.getAdvImages(advertistment);
    }

    @Override
    public List<byte[]> getAdvImagesByte(List<Image> images) {
        FileInputStream fis = null;
        List<byte[]> readAllBytes = new ArrayList<>();
        try {

            for (Image image : images) {
                File f = new File(image.getImgPath());
                fis = new FileInputStream(f);
                byte imageData[] = new byte[(int) f.length()];
                fis.read(imageData);
                byte[] encodeBase64 = Base64.encodeBase64(imageData);
                readAllBytes.add(encodeBase64);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ImageServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ImageServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(ImageServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return readAllBytes;
    }

}
