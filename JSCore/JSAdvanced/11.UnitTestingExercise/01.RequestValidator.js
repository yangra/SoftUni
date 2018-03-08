function validateRequest(obj) {
    let patternMethod = /^(GET|POST|DELETE|CONNECT)$/;
    let patternURI = /^(([a-zA-Z0-9.]+)|(\*))$/;
    let patternVersion = /^(HTTP\/)(0\.9|1\.0|1\.1|2\.0)$/;
    let patternMessage = /^[^<>&\\'"]*$/;

    if (!obj.hasOwnProperty('method')|| !patternMethod.test(obj.method)) {
        throw new Error('Invalid request header: Invalid Method');
    }

    if (!obj.hasOwnProperty('uri') || !patternURI.test(obj.uri)) {
        throw new Error('Invalid request header: Invalid URI');
    }

    if (!obj.hasOwnProperty('version')|| !patternVersion.test(obj.version)) {
        throw new Error('Invalid request header: Invalid Version');
    }

    if (!obj.hasOwnProperty('message') || !patternMessage.test(obj.message)) {
        throw new Error('Invalid request header: Invalid Message');
    }

    return obj;
}
