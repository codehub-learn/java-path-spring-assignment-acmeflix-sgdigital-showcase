package com.acmeflix.mapper;

import com.acmeflix.base.BaseMapper;
import com.acmeflix.domain.Season;
import com.acmeflix.transfer.resource.SeasonResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SeasonMapper extends BaseMapper<Season, SeasonResource> {
}
