package com.lab.service;

import com.lab.dao.SilhouetteDao;
import com.lab.pojo.Silhouette;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SilhouetteService {

    @Autowired
    SilhouetteDao silhouetteDao;

    public List<Silhouette> selectAllSilhouette () {
        return silhouetteDao.selectAllSilhouette();
    }

    public int addSilhouette (Silhouette silhouette) {
        return silhouetteDao.addSilhouette(silhouette);
    }

    public int deleteSilhouette (Silhouette silhouette) {
        return silhouetteDao.deleteSilhouette(silhouette);
    }

}
