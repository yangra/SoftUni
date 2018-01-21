function gradsToDegrees(grads) {
    grads %= 400;
    let degrees = (360 / 400) * grads;

    if (degrees < 0) {
        degrees += 360;
    }

    console.log(degrees);
}

gradsToDegrees(100);
gradsToDegrees(400);
gradsToDegrees(850);
gradsToDegrees(-50);
