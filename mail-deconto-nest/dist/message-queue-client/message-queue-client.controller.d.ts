import { MailService } from 'src/mail/mail.service';
export declare class MessageQueueClientSController {
    private mailService;
    constructor(mailService: MailService);
    interceptedRpc(message: any): Promise<void>;
}
