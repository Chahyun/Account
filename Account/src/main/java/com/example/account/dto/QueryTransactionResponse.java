package com.example.account.dto;

import com.example.account.type.TransactionResultType;
import com.example.account.type.TransactionType;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QueryTransactionResponse {
    private String accountNumber;
    private TransactionType transactionType;
    private TransactionResultType transactionResultType;
    private String transactionId;
    private Long amount;
    private LocalDateTime transactedAt;


    public static QueryTransactionResponse from(TransactionaDto transactionaDto) {
        return QueryTransactionResponse.builder()
                .accountNumber(transactionaDto.getAccountNumber())
                .transactionType(transactionaDto.getTransactionType())
                .transactionResultType(transactionaDto.getTransactionResultType())
                .transactionId(transactionaDto.getTransactionId())
                .amount(transactionaDto.getAmount())
                .transactedAt(transactionaDto.getTransactedAt())
                .build();
    }
}
