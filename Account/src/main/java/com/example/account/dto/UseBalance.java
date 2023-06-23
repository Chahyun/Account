package com.example.account.dto;

import com.example.account.aop.AccountLockIdInterface;
import com.example.account.type.TransactionResultType;
import lombok.*;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

public class UseBalance {
    /**
     * "userId" : 1,
     * "accountNumber":"1000000000",
     * "amount":1000
     */
    @Getter
    @Setter
    @AllArgsConstructor
    public static class Request implements AccountLockIdInterface {
        @NotNull
        @Min(1)
        private Long userId;

        @NotBlank
        @Size(min = 10, max = 10)
        private String accountNumber;

        @NotNull
        @Min(10)
        @Max(1000_000_000)
        private Long amount;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response{
        private String accountNumber;
        private TransactionResultType transactionResultType;
        private String transactionId;
        private Long amount;
        private LocalDateTime transactedAt;


        public static Response from(TransactionaDto transactionaDto) {
            return Response.builder()
                    .accountNumber(transactionaDto.getAccountNumber())
                    .transactionResultType(transactionaDto.getTransactionResultType())
                    .transactionId(transactionaDto.getTransactionId())
                    .amount(transactionaDto.getAmount())
                    .transactedAt(transactionaDto.getTransactedAt())
                    .build();
        }
    }
}
