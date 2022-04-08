import { Controller } from '@nestjs/common';
import {
  MessagePattern,
  Payload,
  Ctx,
  RmqContext,
  Transport,
} from '@nestjs/microservices';
import { MailService } from 'src/mail/mail.service';

@Controller()
export class MessageQueueClientSController {
  constructor(private mailService: MailService) {}

  @MessagePattern('mail-queue-ticket', Transport.RMQ)
  async getTicketMessage(
    @Payload() data: any,
    @Ctx() context: RmqContext,
  ): Promise<void> {
    const channel = context.getChannelRef();
    try {
      await this.mailService.sendTicketMail(JSON.parse(data.data));
      channel.ack(context.getMessage());
    } catch (e) {
      channel.nack(context.getMessage());
    }
  }
}
