"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.MessageQueueClientSController = void 0;
const nestjs_rabbitmq_1 = require("@golevelup/nestjs-rabbitmq");
const common_1 = require("@nestjs/common");
const mail_service_1 = require("../mail/mail.service");
let MessageQueueClientSController = class MessageQueueClientSController {
    constructor(mailService) {
        this.mailService = mailService;
    }
    async interceptedRpc(message) {
        await this.mailService.sendTicketMail(message);
    }
};
__decorate([
    (0, nestjs_rabbitmq_1.RabbitRPC)({
        queue: 'user-ticket-mail',
    }),
    __metadata("design:type", Function),
    __metadata("design:paramtypes", [Object]),
    __metadata("design:returntype", Promise)
], MessageQueueClientSController.prototype, "interceptedRpc", null);
MessageQueueClientSController = __decorate([
    (0, common_1.Controller)(),
    __metadata("design:paramtypes", [mail_service_1.MailService])
], MessageQueueClientSController);
exports.MessageQueueClientSController = MessageQueueClientSController;
//# sourceMappingURL=message-queue-client.controller.js.map