import { MailerService } from '@nestjs-modules/mailer';
export declare class MailService {
    private mailerService;
    constructor(mailerService: MailerService);
    sendTicketMail(payload: {
        user: any;
        ticket: any;
    }): Promise<SentMessageInfo>;
}
