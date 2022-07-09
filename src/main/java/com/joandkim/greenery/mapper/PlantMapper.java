package com.joandkim.greenery.mapper;

import com.joandkim.greenery.dto.PlantSearchFilter;
import com.joandkim.greenery.vo.Plant;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PlantMapper {
    List<Plant> getPlants(PlantSearchFilter psf);
}
