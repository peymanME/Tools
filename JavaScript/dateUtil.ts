import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})

export class DateUtil {

constructor() {  }


public calcDate(date1: Date,date2: Date) {
  // date2 > date1
    var diff = Math.floor(date2.getTime() - date1.getTime());
    var day = 1000 * 60 * 60 * 24;        

    var days = Math.floor(diff/day);
    var years = Math.floor(days/365);
    var months = Math.floor((days%365)/30);

    var message = "";
    message += " from ";
    if (years > 1)
    	message += years + " years and ";
    else 
    	message += years + " year and ";
    if (months > 1)
    	message += months + " months ";
   	else
   		message += months + " month ";

    return message
  }

}
