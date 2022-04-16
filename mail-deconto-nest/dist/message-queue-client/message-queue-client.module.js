"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.MessageQueueClientModule = void 0;
const common_1 = require("@nestjs/common");
const mail_service_1 = require("../mail/mail.service");
const message_queue_client_controller_1 = require("./message-queue-client.controller");
const nestjs_rabbitmq_1 = require("@golevelup/nestjs-rabbitmq");
let MessageQueueClientModule = class MessageQueueClientModule {
};
MessageQueueClientModule = __decorate([
    (0, common_1.Module)({
        imports: [
            nestjs_rabbitmq_1.RabbitMQModule.forRoot(nestjs_rabbitmq_1.RabbitMQModule, {
                uri: 'amqp://guest:guest@rabbitmq-server:5673',
                enableControllerDiscovery: true,
            }),
        ],
        providers: [mail_service_1.MailService],
        controllers: [message_queue_client_controller_1.MessageQueueClientSController],
    })
], MessageQueueClientModule);
exports.MessageQueueClientModule = MessageQueueClientModule;
//# sourceMappingURL=message-queue-client.module.js.map