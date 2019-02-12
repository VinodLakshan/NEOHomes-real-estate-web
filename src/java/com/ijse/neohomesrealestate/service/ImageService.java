/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.neohomesrealestate.service;

import com.ijse.neohomesrealestate.model.Advertistment;
import com.ijse.neohomesrealestate.model.Image;
import java.io.IOException;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author vinod
 */
public interface ImageService {
    
    public String saveImages(List<Image> images);
    
    public List<Image> setImagestoFolder(Advertistment lastAdv);
    
    public String saveProImg(MultipartFile file, String nic) throws IOException;
    
    public byte[] previewProImg();
    
    public List<Image> getAdvImages(Advertistment advertistment);
    
    public List<byte[]> getAdvImagesByte(List<Image> images);
}
