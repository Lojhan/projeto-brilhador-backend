import { RabbitRPC } from '@golevelup/nestjs-rabbitmq';
import { Controller } from '@nestjs/common';
import { MailService } from 'src/mail/mail.service';

@Controller()
export class MessageQueueClientSController {
  constructor(private mailService: MailService) {}

  @RabbitRPC({
    queue: 'user-ticket-mail',
  })
  async interceptedRpc(message: any) {
    await this.mailService.sendTicketMail(message);
  }
}
