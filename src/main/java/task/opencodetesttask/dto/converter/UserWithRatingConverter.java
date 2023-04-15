package task.opencodetesttask.dto.converter;

import org.springframework.stereotype.Component;
import task.opencodetesttask.dto.UserWithRatingDto;
import task.opencodetesttask.entities.Person;

@Component
public class UserWithRatingConverter implements GenericConverter<Person, UserWithRatingDto> {

    @Override
    public UserWithRatingDto apply(Person person) {
        UserWithRatingDto requestedDto = new UserWithRatingDto();
        requestedDto.setMail(person.getMail());
        requestedDto.setPoints(person.getPoints());
        requestedDto.setId(person.getId());
        return requestedDto;
    }
}
