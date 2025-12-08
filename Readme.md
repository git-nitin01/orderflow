# 📦 Orderflow — Modern Order Lifecycle Platform

> A real-world simulation of Amazon-style Order Management: order creation, inventory reservation, payment orchestration, and delivery tracking — implemented with event-driven microservices.

---

## ❗ Problem Statement

Most e-commerce projects stop at **“Add to Cart → Checkout → Save Order”**, creating an unrealistic view of how real systems work.

In real-world commerce, the complexity begins **after** an order is placed:

- reserving inventory accurately  
- handling stock shortages  
- asynchronous payment execution  
- dealing with failures & retries  
- shipment orchestration  
- eventual consistency  
- scaling order volume  
- maintaining audit logs & traceability  

These are the hard parts of Amazon, Walmart, Shopify, Flipkart, etc.  
These are the parts developers rarely show in portfolio projects.

**Orderflow exists to demonstrate these real-world challenges.**

---

## 💡 Insight

An order is **not** a single DB write.  
It is a **distributed workflow** across multiple domains:

Order Created
→ Reserve Inventory
→ Authorize Payment
→ Confirm Order
→ Notify Customer


This requires:

- event-driven communication  
- asynchronous processing  
- domain separation  
- resilient workflows  
- business events as the source of truth  

CRUD cannot model this.  
**Event-driven architecture can.**

---

## 🚀 Solution Vision

Orderflow is designed as a **modern Order Management System (OMS)** built with:

### ✔ Event-Driven Microservices  
- loosely coupled  
- publish/subscribe  
- asynchronous workflows  
- replayable event log (Kafka)

### ✔ Domain-Driven Design  
- modules: Order, Inventory, Product, Payment  
- each domain owns its logic  
- separation of responsibility  

### ✔ Kafka as the Communication Backbone  
- events represent business actions  
- services react independently  
- full traceability of system state  

### ✔ Scalable & Extensible  
- supports real failure scenarios  
- easy to add new services (Shipping, Notifications)  
- architecture mirrors real enterprise systems  

---

## 🏗 Architecture Overview

```text
              ┌───────────────────────┐
              │      React Client     │
              │  Product Listing UI   │
              │  Checkout Experience  │
              └───────────┬───────────┘
                          │ REST
            ┌─────────────▼─────────────┐
            │       API Gateway         │
            │     (Spring Boot)         │
            └─────────────┬─────────────┘
                          │ calls
            ┌─────────────▼─────────────┐
            │       Order Service       │
            │  createOrder()            │
            │  publish OrderCreated     │
            └─────────────┬─────────────┘
                          │ Kafka Event
    ┌─────────────────────▼──────────────────────┐
    │              Inventory Service             │
    │  listen(OrderCreatedEvent)                 │
    │  (future) reserve & emit events            │
    └─────────────────────┬──────────────────────┘
                          │ Kafka Event
            ┌─────────────▼─────────────┐
            │       Payment Service     │
            │ simulate payment (future) │
            │ emit PaymentAuthorized    │
            └───────────────────────────┘

```
---

## 🧬 Event Model

### **Implemented**
#### `OrderCreatedEvent`
- `orderId`
- `totalAmount`
- `createdAt`

### **Planned**
#### `InventoryReservedEvent`
- `orderId`
- `items`
- `reservedQuantities`

#### `InventoryRejectedEvent`
- `orderId`
- `reason`

#### `PaymentAuthorizedEvent`
- `orderId`
- `paymentId`
- `status`

#### `OrderCompletedEvent`
- `orderId`
- `deliveryEta`

---

## 🧩 Domain Boundaries

The backend is structured into **bounded contexts**, not a monolith:

- /backend
- /product → product catalog & pricing
- /order → order lifecycle + events
- /inventory → stock validation & reservation
- /payment → payment simulation (future)
- /messaging → Kafka integration & topic conventions


This mirrors real distributed commerce systems.

---

## 🌟 Features

### ✅ Current
- React frontend with product grid & ratings  
- Order Service with line items & totals  
- In-memory Product & Inventory repositories  
- Kafka producer for OrderCreatedEvent  
- Inventory Service listening to Kafka events  
- Modular, DDD-style backend structure  

### 🛠 Short-Term Roadmap
1. Inventory reservation logic  
2. InventoryReserved / InventoryRejected events  
3. Payment authorization workflow  
4. Order status lifecycle  
5. Swagger API documentation  
6. Docker Compose (Kafka + Services)  
7. GitHub Actions CI/CD  

### 🚚 Long-Term Vision
- Shipping Service  
- Notification Service  
- Saga pattern orchestration  
- Retry queues & DLQs  
- Outbox pattern for event reliability  
- Postgres storage  
- Kubernetes deployment  
- Distributed tracing (OpenTelemetry)  

---

## 🧭 System Workflow (High-Level)

### Order Creation
1. UI sends request to `/api/orders`
2. Order Service calculates total  
3. Order Service persists state  
4. Order Service emits `OrderCreatedEvent`

### Inventory Reaction
1. Inventory listens on `orderflow.order.created`
2. (future) checks stock & reserves  
3. emits:
   - `InventoryReservedEvent` **or**  
   - `InventoryRejectedEvent`

### Payment
1. Payment listens to inventory events  
2. simulates authorization  
3. emits `PaymentAuthorizedEvent`

### Order Completion
- Order Service sets status  
- (future) Notifications  
- (future) Shipment workflow  

---

## 🛠 Tech Stack

### **Frontend**
- React + TypeScript  
- Vite  
- Tailwind CSS  

### **Backend**
- Java 17+  
- Spring Boot  
- Spring Web  
- Spring Kafka  
- Domain modules  

### **Messaging**
- Apache Kafka  
- JSON event contracts  

### **Infrastructure**
- In-memory data  
- Docker Compose (future)  
- CI/CD (future)  

---

## 🎯 Purpose

Orderflow is built to demonstrate **real system design**, including:

- distributed workflows  
- asynchronous events  
- DDD boundaries  
- microservice decomposition  
- event sourcing concepts  
- system reliability patterns  

Instead of a CRUD portfolio app, this project shows **true depth**.

---

## 👤 Author

**Nitin Bawa**  
Full-Stack Developer  
Java • Spring Boot • React • Kafka  

---

## ❤️ Contribute

Open to architecture discussions, suggestions, and collaboration.

