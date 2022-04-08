import { Inject, Injectable } from '@nestjs/common';
import { ClientProxy } from '@nestjs/microservices';
import { PartialObserver } from 'rxjs';

@Injectable()
export class MessageQueueClientService {
  constructor(@Inject('AUTH_SERVICE') private client: ClientProxy) {
    this.client.connect();
  }

  sendNotification(
    pattern: string,
    record: string,
    observer?: PartialObserver<unknown>,
  ) {
    return this.client.send(pattern, { data: record }).subscribe(observer);
  }
}
