package ru.dezlo.room.enterprise.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.dezlo.room.enterprise.models.ModelClan;
import ru.dezlo.room.security.models.ModelUser;
import ru.dezlo.room.security.responses.ResponseNicknames;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseClans {

    private List<ResponseNicknames> users;

    private List<ModelClan> clans;

}
