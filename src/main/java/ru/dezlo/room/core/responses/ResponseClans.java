package ru.dezlo.room.core.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.dezlo.room.core.models.ModelClan;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseClans {

    private List<ResponseNicknames> users;

    private List<ModelClan> clans;

}
