package com.lab.dao;

import com.lab.pojo.Silhouette;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SilhouetteDao {

    List<Silhouette> selectAllSilhouette();
    int addSilhouette(Silhouette silhouette);
    int deleteSilhouette(Silhouette silhouette);

}
