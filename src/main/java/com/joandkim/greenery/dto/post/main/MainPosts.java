package com.joandkim.greenery.dto.post.main;

import com.joandkim.greenery.dto.post.BriefPost;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class MainPosts {
//    private TodayPlant todayPlant;
    private List<BriefPost> manyHitsPlants;

    public MainPosts(List<BriefPost> manyHitsPlants) {
        this.manyHitsPlants = manyHitsPlants;
    }
}
