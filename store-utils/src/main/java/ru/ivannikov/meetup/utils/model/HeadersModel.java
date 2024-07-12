package ru.ivannikov.meetup.utils.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import ru.ivannikov.meetup.utils.enumeration.*;

import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class HeadersModel {

    @JsonProperty("correlation_id")
    private UUID correlationId;

//    @JsonProperty("command_saga_id")
//    private UUID commandSagaId;

//    @JsonProperty("PARTITION_ID")
//    private String partitionId;

    @JsonProperty("event_aggregate_type")
    private EventAggregateTypeEnum eventAggregateType;

    @JsonProperty("event_aggregate_id")
    private EventAggregateIdEnum eventAggregateId;

    private DestinationEnum destination;

    @JsonProperty("command_type")
    private CommandTypeEnum commandType;

    @JsonProperty("command_reply_to")
    private ReplyToEnum commandReplyTo;

    private long date;

    public HeadersModel(UUID correlationId,
                        EventAggregateTypeEnum eventAggregateType,
                        EventAggregateIdEnum eventAggregateId,
                        CommandTypeEnum commandType,
                        long date) {
        this.correlationId = correlationId;
        this.eventAggregateType = eventAggregateType;
        this.eventAggregateId = eventAggregateId;
        this.commandType = commandType;
        this.date = date;
    }
}