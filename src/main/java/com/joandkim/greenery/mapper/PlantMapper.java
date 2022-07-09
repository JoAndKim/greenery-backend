package com.joandkim.greenery.mapper;

import com.joandkim.greenery.vo.Plant;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PlantMapper {
    List<Plant> getPlants();
}
