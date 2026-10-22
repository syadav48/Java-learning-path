# Top 15 Low-Level Design (LLD) Problems for Java Interviews

Since you're targeting Java full-stack and senior developer roles, I'd focus on LLD problems that test object-oriented
design, SOLID principles, design patterns, concurrency, extensibility, and practical Java implementation.

At 2 LLD problems per week, you can complete this roadmap in about 8 weeks for the first 15 problems, with one
additional problem or revision session in the final week.

The important thing is not just to draw UML diagrams. For each problem, you should be able to explain the requirements,
identify classes and interfaces, define APIs, implement the core flows in Java, and discuss design trade-offs.

## Your ranked LLD roadmap

[Designing a Parking Lot System : Low-Level Design (LLD) Series – Part 6 | by Tirupati Rao (bitbee) | bitbee | Medium](https://images.openai.com/static-rsc-4/dO38Vwoz3kBGuQu50MssPQYG38YCoRZOnE3AQPpVE1gHwHenSNDcczAK1GcH5yxID2AWVFEXG42ps9070OEovVnNnmln8qm1lJVaqBqtNuwZPPiU1t8Oq9_d2qv34X2eAeVCinfpRX5jnrTFQEKyfWMn9T-g8Yf7yUMEdRC-Ogs?purpose=inline)

## 1. Parking Lot System

Must-do

Difficulty: Easy–Medium

Design a parking system supporting different vehicle types, parking spots, entry/exit gates, tickets, and fee
calculation.

Core concepts: Inheritance vs. composition, Strategy pattern, Factory pattern, interfaces, extensible pricing.

Interview extension: Multiple floors and concurrent spot allocation.

[Day 26: LLD Design — Elevator System | Java Code | by TechieContent | Jan, 2026 | Medium](https://images.openai.com/static-rsc-4/06F1FmCk3jiim6iieepFED8czALH-5NuzNNasHg2nQw8p_TiMQDvjDVRq_t3OmRhdmmq5hInBBjOncn3OnlY5OAfGIet6GaLqKm1tTISMy2quwGXKVf2KS3NWbwOFb1d974i4515LBOhDgvcooH6NsnR04Zasrn6PRIJul3Qynk?purpose=inline)

## 2. Elevator System

Difficulty: Medium–Hard

Design multiple elevators that handle requests from different floors and select which elevator should serve each
request.

Core concepts: State pattern, scheduling strategy, enums, concurrency, separation of dispatching and movement.

Interview extension: Prioritize requests while minimizing waiting time.

[Design Movie Ticket Booking System - Astik Anand](https://images.openai.com/static-rsc-4/76vYHO7Bnhygktq9qTqYDLiSYvcXLOkKaY_qe8h0__PJv_01ROakiKgUUdN4QilwUOnk0O-SzD1LJJEi66OmUdwYBV5RNZ2AXuTRIECWYVD0Y4tYUA4_9yT10e3P_AVPrZoL0wtKmk_N-Dl_1kGczLdCkUDOpQ0lbnVnNQLp4v0?purpose=inline)

## 3. Movie Ticket Booking System

Must-do

Difficulty: Medium–Hard

Design movies, theatres, screens, shows, seats, reservations, payments, and cancellations.

Core concepts: Entity relationships, seat locking, booking state machine, transaction boundaries, concurrency.

Interview extension: Prevent two users from booking the same seat.

[💸 Designing Splitwise from Scratch: How I Built an Expense Sharing System in Java | by Vishal Saraswat | Medium](https://images.openai.com/static-rsc-4/NQiUey2GEJyQC-9ZLwr4sB5fo4ZImmsmZjsvGEDtIu9vFedKkMcdF4M1KxUhaeNphc4tDZ2nqDHIBQ3nv7EckGcBMI2eqimI_E4BSKGx9O9GYEWLPF8TVl0pRczgsUN4NerHt98Ovv0APMr3DN6HigdGvcxjtbDlRj83YrP8DJ8?purpose=inline)

## 4. Splitwise / Expense Sharing

Difficulty: Medium–Hard

Model users, groups, expenses, equal/exact/percentage splits, balances, and settlements.

Core concepts: Strategy pattern, domain modeling, money calculations, validation, balance simplification.

Interview extension: Minimize the number of transactions required to settle debts.

[State Diagram Generator - Free AI State Machine Diagram Maker](https://images.openai.com/static-rsc-4/vVVHPD_mCm7f9Hy1Dok2i8hRZ6PS-YuQc2Jg0FkpNmEaCSGHlt3ZDuv6pcXD2TtUAvPc3Jyq_pttX3KdjnVFJ6PPhsIINVWdJxJJ65x3gaLDJfWGT9A7BqDpQxkoiP8_T7DuBXoD6Xdd9QU-AslIZkwazvB-4kmRbzvgRvwmm24?purpose=inline)

## 5. Vending Machine

Difficulty: Easy–Medium

Model product selection, inventory, payments, change, dispensing, and refunds.

Core concepts: State pattern, encapsulation, state transitions, interfaces, exception handling.

Interview extension: Handle insufficient inventory and failed payment without losing money.

[Day 28: LLD Design — ATM Machine | Java Code | by TechieContent | Feb, 2026 | Medium](https://images.openai.com/static-rsc-4/ZbCy__m-Wrr7z6R9zbnGRdlseDwnvcMN0izZygliBMewhzbd80rG_jsLedUnEMaGqGCaeN0Mq8Ys83XuSGHd7zYBuycr2C2wWjFdyLmae03IwXpX2TisxNY9SgzwhudZF2x7Uhw3vb8Qt0QWUrzDonTDnXL8ZP5HUYcw0Jt5xlY?purpose=inline)

## 6. ATM System

Difficulty: Medium

Support card validation, authentication, withdrawals, deposits, balance checks, and transaction receipts.

Core concepts: State pattern, service abstractions, transaction processing, error handling, SOLID.

Interview extension: Ensure cash dispensing and account debiting remain consistent.

[Class diagram in Unified Modeling Language (UML)](https://images.openai.com/static-rsc-4/F4T-MpzyFEtuQ4bMYJlF8_tA-V5V5C1m_hPUMyaK9pq-NyfmqJk38P3uvBHbQTkZgs6lKyjYCZJ8KYiMkdBWgd-sO72uHEEkLmDq9UMQTwL6NhVOyIlqjh8OH59lCnze23CdQODhqZVPvLufhWT5DTVga6gKzidNp6bbueTAagk?purpose=inline)

## 7. Library Management System

Difficulty: Easy–Medium

Manage books and physical copies, members, borrowing, returns, reservations, and fines.

Core concepts: Composition, entity relationships, repository abstraction, domain rules.

Interview extension: Reservation queues and overdue fine policies.

[Designing a Food Delivery System — Low-Level Design (LLD in Java) | by Ankit Kumar Srivastava | Medium](https://images.openai.com/static-rsc-4/AZqx9popAsRSblalmy6JWl69r7bQWJdvMagP28jnc12h733Ep9sik4frQqgf1DCWkrDworRIwjMpaVmpr2ZjzTl4ecyuRSjjUK0KyzzVvUY3wUUlMKj_nbLRdWSm7SWaee-ujHJpadTciHDzN9arDhNlzY2PQSxN4ciPnhKjjbI?purpose=inline)

## 8. Food Delivery System

Difficulty: Medium–Hard

Design customers, restaurants, menus, carts, orders, delivery partners, and payments.

Core concepts: Order lifecycle, Strategy pattern, Observer pattern, interfaces, state transitions.

Interview extension: Assign delivery partners and handle cancellation/refunds.

[Design Uber in 5 Classes: Clear OOD for Interviews](https://images.openai.com/static-rsc-4/LKP6EKPBplA7AoUz6DAWZJHL1wG9XyjUaCZOLQem-baSz1EepA0rqgVLHS0AG3zGEDzW2djo0c8gBwoU_dzxe2CMfSKRQcuWnD7rMAFQba0Jd2jxOCfbRncY9_u9L_K3Ujv6X1__s4sPdLSJ7iguPAi1QB1wIKceedGSfjcuAyg?purpose=inline)

## 9. Ride-Sharing System (Uber/Ola)

Difficulty: Hard

Design riders, drivers, trip requests, driver matching, fare calculation, trip status, and payments.

Core concepts: Strategy, State, Observer, matching algorithms, concurrent driver assignment.

Interview extension: Prevent one driver from accepting two simultaneous rides.

[Day 29: Mock Design — Chess or Snake Game | by TechieContent | Feb, 2026 | Medium](https://images.openai.com/static-rsc-4/cgb65eurLoVJVROmNdUdaRk6b-l4EnrGd8wdqysp_GhTcKc20MgHPUBv5kfnhSRg6RDkfYpoyCIPYm5Erew5SaUNlgezUS4xueyPecP0_HZI03M_YRmJQNmfJzT_dXIVDHhHBWiRQX8qqYWzXZnmXHazdCclGsmgr17KHUjxqT4?purpose=inline)

## 10. Chess Game

Difficulty: Medium–Hard

Design a chessboard, pieces, players, legal moves, turns, check, checkmate, and game state.

Core concepts: Polymorphism, inheritance vs. composition, Strategy pattern, domain invariants.

Interview extension: Undo moves and support special moves such as castling and en passant.

[Observer Design Pattern. Introduction | by Deva25 | Medium](https://images.openai.com/static-rsc-4/sgHv6SX7MzMnlzkbBMofphkV-8bT9e2EVrL4MYeuc6QhntmCeHLyDpvSXNiNtJ0y7wnSZyj087TS-GnDfPJvWL0WYqqzIKnWKQBbvb9VfzYhKoEZbH52-MpxHHq4mpwDYHkrXLcT2IdLPg_GhMQU1lq2Yd8E92-YL8ijjmV1A9A?purpose=inline)

## 11. Notification Service

Difficulty: Medium

Send email, SMS, and push notifications based on user preferences and events.

Core concepts: Strategy, Factory, Observer, provider interfaces, retries and extensibility.

Interview extension: Add a new notification channel without changing existing business logic.

[LRU Cache Implementation. Problem Restatement | by Code With Clarity | Medium](https://images.openai.com/static-rsc-4/A5vUgTtnJaop2qQZUoi_aanJLVZRI4tVx-SnBmAVimNOR4A36vacsiNeN_7Mj68TjWaaHQV5Q7sEry48pQgj-uN7PUl35deIxqRBT-Y5xYc0BgiVGSHR7PgZPqn3f7qxudGxRk2KlI54lc8WmvtDzgVqAcdqvzb9ZuXcTLHTJtE?purpose=inline)

## 12. LRU Cache

Difficulty: Medium

Implement `get` and `put` with constant-time average complexity and evict the least recently used entry.

Core concepts: HashMap, doubly linked list, encapsulation, data structure invariants.

Interview extension: Thread-safe cache, TTL expiration, and eviction policies.

[A Guide to Rate Limiting Strategies - ByteByteGo Newsletter](https://images.openai.com/static-rsc-4/WCGA0NWhd6MWLrRrJ8c3syOeMmb14FW37Tnm4vXgN_xkjdke75Wiir3zb2AX-d_RrBGEGoXNxuxaxqPm1oV-eSC0Fj1LF0oUZKPYUv5nfPwlVirLNMWXcKnTie4WB2s_WPYqItnMZWQvw2ruY5vPTeFV1L6TEmi30FOkRSCL71k?purpose=inline)

## 13. Rate Limiter

Difficulty: Medium–Hard

Control request frequency per user or client using configurable limits.

Core concepts: Strategy pattern, Token Bucket, Sliding Window, clock abstraction, concurrency.

Interview extension: Support multiple rate-limiting policies and distributed deployments.

[日志-Log4j，Logback，Log4j2和Slf4j日志框架的结构原理 - 个人文章 - SegmentFault 思否](https://images.openai.com/static-rsc-4/h3CigVomZdBh9kh8mwl9gSHTOsM6InLJRmxJiCywcIvrtaMS2hjAK_4jWwfIrMVdDHgAP248whR0J3JoMpvLUp8w3pT1oMh62IuSEogsbBFUnN95ZlOnVnniCk-2WA62xCb9PUuAoUEMqlszR8ptzojvV-y-YCw9uTbCU6jaYcQ?purpose=inline)

## 14. Logging Framework

Difficulty: Medium–Hard

Build a reusable logger supporting log levels, formatters, and console/file/database appenders.

Core concepts: Chain of Responsibility, Factory, Singleton trade-offs, extensible appenders.

Interview extension: Asynchronous logging, buffering, and concurrent writes.

[Online Shopping System Uml Diagrams 9 Best Uml Diagrams For](https://images.openai.com/static-rsc-4/-nz2XQT9iEwpACe-8K2wlfv2xeoYjI3PzX66C3wy0ueQWFhohKpb08vBGxaB83FPY2B_NcgTWOMkHCNU_bQIi0q4ppY3NG3Ut19huye0P4fZhc5QlraGWI6kzSPxmOCPEAwfipJJWRAPQvq76ObY9hfDI7ZqPdkeYKO5cX3ur4U?purpose=inline)

## 15. E-Commerce Shopping Cart and Checkout

Difficulty: Medium–Hard

Design products, carts, inventory, coupons, checkout, orders, payments, and refunds.

Core concepts: SOLID, Strategy for discounts, pricing abstraction, transaction boundaries, inventory consistency.

Interview extension: Concurrent checkouts, idempotent payments, and inventory reservation.

## Your 8-week schedule

At two problems per week, complete two problems each week and use the remaining time for revision and mock interviews.

| Week | Problem 1            | Problem 2                              |
|------|----------------------|----------------------------------------|
| 1    | Parking Lot          | Vending Machine                        |
| 2    | Library Management   | ATM                                    |
| 3    | LRU Cache            | Notification Service                   |
| 4    | Movie Ticket Booking | Splitwise                              |
| 5    | Elevator System      | Chess Game                             |
| 6    | Food Delivery        | E-Commerce Checkout                    |
| 7    | Ride-Sharing         | Rate Limiter                           |
| 8    | Logging Framework    | Revise weakest design / mock interview |

This sequence starts with small object models and progressively introduces state management, extensibility, concurrency,
and more involved workflows. Week 8 contains one new problem and one revision/mock exercise, so you'll cover all 15
without rushing.

## The framework you should follow for every LLD interview

Use the same sequence every time.

### 1

Requirements

Clarify scope, functional requirements, and constraints.

### 2

Core entities

Identify classes, responsibilities, relationships, and enums.

### 3

Class diagram

Draw associations, composition, inheritance, and interfaces.

### 4

Design patterns

Use patterns only where they solve a concrete problem.

### 5

Java implementation

Write the core classes and the main business flows.

### 6

Edge cases

Handle invalid states, failures, concurrency, and duplicate requests.

### 7

Trade-offs

Explain extensibility, complexity, and alternative designs.

For each problem, aim for one focused practice session to model and diagram the design, another to implement the
important Java classes, and a final review to test edge cases and explain the design aloud.

My recommendation: Start with Parking Lot. It is a great first exercise for understanding entities, responsibilities,
interfaces, and extensible pricing before moving into more complex designs.