package org.springframework.samples.petclinic.mapper;

import java.util.Collection;
import org.mapstruct.Mapping;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.PetType;
import org.springframework.samples.petclinic.rest.dto.PetDto;
import org.springframework.samples.petclinic.rest.dto.PetFieldsDto;
import org.springframework.samples.petclinic.rest.dto.PetTypeDto;



/**
 * Mapea Pet y PetDto usando mapstruct
 */
@Mapper(uses = VisitMapper.class)
public interface PetMapper {

    @Mapping(source = "owner.id", target = "ownerId")
    PetDto aMascotaDto(Pet pet);

    Collection<PetDto> aMascotasDto(Collection<Pet> pets);

    Collection<Pet> aMascotas(Collection<PetDto> pets);

    @Mapping(source = "ownerId", target = "owner.id")
    Pet aMascota(PetDto petDto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "owner", ignore = true)
    @Mapping(target = "visits", ignore = true)
    Pet aMascota(PetFieldsDto petFieldsDto);

    PetTypeDto aTipoMascotaDto(PetType petType);

    PetType aTipoMascota(PetTypeDto petTypeDto);

    Collection<PetTypeDto> aTiposMascotaDto(Collection<PetType> petTypes);
}
