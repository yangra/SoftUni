class StormWatcher {
    constructor(temperature, humidity, pressure, windSpeed) {
        this.id = StormWatcher.id;
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        this.windSpeed = windSpeed;
    }

    get weather() {
        if (this.temperature < 20 && (this.pressure < 700 || this.pressure > 900) && this.windSpeed > 25) {
            return 'Stormy';
        }

        return 'Not stormy';
    }

    static get id(){
        if(StormWatcher._id === undefined)
            StormWatcher._id = 0;
        return StormWatcher._id++;
    }

    toString() {
        return `Reading ID: ${this.id}\n` +
            `Temperature: ${this.temperature}*C\n` +
            `Relative Humidity: ${this.humidity}%\n` +
            `Pressure: ${this.pressure}hpa\n` +
            `Wind Speed: ${this.windSpeed}m/s\n` +
            `Weather: ${this.weather}`;
    }
}