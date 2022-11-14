package com.acmeflix.mapper;

import com.acmeflix.base.BaseMapper;
import com.acmeflix.domain.Episode;
import com.acmeflix.transfer.resource.EpisodeResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EpisodeMapper extends BaseMapper<Episode, EpisodeResource> {
}
