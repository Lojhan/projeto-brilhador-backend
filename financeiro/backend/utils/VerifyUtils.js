const moment = require('moment');

getJsonFail = function(){
    var json = {};
    json.status = "NOK";
    json.code = 0;
    return json;
}

jsonFail = function() {
    return getJsonFail();
}

isValid = function(obj) {
    if(obj == undefined)return false;
    if(obj == null)return false;
    try{
        if(obj.toString() == "")return false;
    }catch (e) {}
    return true;
}

isNotValid = function(obj) {
    return !isValid(obj);
}

isBoolean = function(obj) {
    if(isValid(obj)){
        var str = obj.toString().toLowerCase()
        if(str == "1" || str == "true")return true
        else if(str == "0" || str == "false")return true
    }
    return false
}

isNotBoolean = function(obj) {
    return !isBoolean(obj)
}

isMoneyFormat = function(obj){
    if(isValid(obj)) {
        return /^[0-9]\d*(((,\d{3}){1})?(\.\d{0,2})?)$/.test(obj);
    }
    return false
}

isNotMoneyFormat = function(obj){
    return !isMoneyFormat(obj)
}

isDate = function(obj){
    if(isValid(obj)) {
        return moment(obj, "YYYY-MM-DD", true).isValid();
    }
    return false;
}

isNotDate = function(obj){
    return !isDate(obj)
}

isTime = function(obj){
    if(isValid(obj)) {
        return moment(this, "HH:mm", true).isValid();
    }
    return false;
}

isNotTime = function(obj){
    return !isTime(obj);
}

isNumber = function(obj) {
    if(isValid(obj)){
        var str = obj.toString().toLowerCase()
        if(str.isNumber())return true
    }
    return false
}

isNotNumber = function(obj) {
    return !isNumber(obj);
}

isMesesCalendario = function(obj) {
    if(isNumber(obj)){
        var value = obj.toString();
        if (value) {
            value = value.replace(/\./g, '');
            value = value.replace(/\,/g, '.');
        }
        if(parseInt(value) == NaN){
            return false
        }
        var num = parseInt(value);
        if(num > 0 && num < 13)return true
        else return false
    }
    return false
}

isNotMesesCalendario = function(obj) {
    return !isMesesCalendario(obj)
}

isValidAndPhoneNumber = function(obj) {
    if(isValid(obj)){
        if(obj.toString().isPhoneNumber()){
            return true
        }
    }
    return false
}

isNotValidAndPhoneNumber = function(obj) {
    return !isValidAndPhoneNumber(obj)
}

isNullOrArrayEmpty = function(obj) {
    if(isValid(obj) && Array.isArray(obj))return false;
    return true;
}

isValidCallProcedure = function(obj) {
    if(!isNullOrArrayEmpty(obj)){
        var list = obj[0]
        if(!isNullOrArrayEmpty(list)
            && isBoolean(list[0].TRUE)){
            return true
        }
    }
    return false
}

isValidAndCPF = function(obj) {
    if(isValid(obj)){
        if(obj.toString().isCPF() || obj.toString().isCNPJ()){
            return true;
        }
    }
    return false
}

isNotValidAndCPF = function(obj) {
    return !isValidAndCPF(obj)
}


getOrNull = function(variavel){
    if(isValid(variavel)){
        if(variavel.toString() != ""){
            return variavel.toString()
        }
    }
    return null
}

isTimeStamp = function(obj){
    if(isValid(obj)) {
        return moment(obj, "YYYY-MM-DD HH:mm", true).isValid();
    }
    return false
}

isNotTimeStamp = function(obj){
    return !isTimeStamp(obj)
}

isValidAndLegth = function(obj,length){
    if(isValid(obj)){
        if(obj.toString().length >= length)return true
    }
    return false
}

isNotValidAndLegth = function(obj,length){
    return !isValidAndLegth(obj,length)
}

getBoolean = function(obj, defaultValue = false){
    if(isValid(obj)) {
        var temp = obj.toString().toLowerCase()
        if (temp == "false" || temp == "0") return false;
        else if (temp == "true" || temp == "1") return true;
    }
    return defaultValue;
}

getFloat = function(obj, defaultValue = 0.0){
    if(isMoneyFormat(obj.toString())){
        return parseFloat(obj.toString())
    }
    return defaultValue
}


getInt = function(obj, defaultValue = 0.0){
    if(isNumber(obj.toString())){
        return parseInt(obj.toString())
    }
    return defaultValue
}