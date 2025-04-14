package org.springframework.samples.petclinic.mapper;


import org.springframework.samples.petclinic.model.Visit;
import org.springframework.samples.petclinic.rest.dto.VisitDto;
import org.springframework.samples.petclinic.rest.dto.VisitFieldsDto;


/**
 * Correspondance entre Visit et VisitDto en utilisant mapstruct
 */
@Mapper(uses = PetMapper.class)
public interface VisitMapper {
    @Mapping(source = "petId", target = "pet.id")
    Visit versVisite(VisitDto visitDto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "pet", ignore = true)
    Visit versVisite(VisitFieldsDto visitFieldsDto);

    @Mapping(source = "pet.id", target = "petId")
    VisitDto versVisiteDto(Visit visit);

    Collection<VisitDto> versVisitesDtos(Collection<Visit> visits);
}
