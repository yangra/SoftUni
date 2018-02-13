function playing(input) {
    let[songName, artist, duration] = input;
    console.log(`Now Playing: ${artist} - ${songName} [${duration}]`);
}

playing(['Number One', 'Nelly', '4:09']);
