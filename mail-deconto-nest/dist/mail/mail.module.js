"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.MailModule = void 0;
const handlebars_adapter_1 = require("@nestjs-modules/mailer/dist/adapters/handlebars.adapter");
const common_1 = require("@nestjs/common");
const mail_service_1 = require("./mail.service");
const options = {
    transport: {
        host: 'smtp.mandrillapp.com',
        authenticationType: 'login',
        port: 587,
        auth: {
            user: 'viniciuslojhan@gmail.com',
            pass: '123456Ab!',
        },
    },
    template: {
        dir: `${__dirname}/templates`,
        adapter: new handlebars_adapter_1.HandlebarsAdapter(),
        options: {
            strict: true,
        },
    },
};
let MailModule = class MailModule {
};
MailModule = __decorate([
    (0, common_1.Module)({
        imports: [],
        providers: [mail_service_1.MailService],
    })
], MailModule);
exports.MailModule = MailModule;
//# sourceMappingURL=mail.module.js.map