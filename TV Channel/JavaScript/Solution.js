export function getSortedShows(shows, times) {
    const sortedTimes = times.slice().sort((curr, next) => curr.starttime - next.starttime)
    const sortedShows = sortedTimes.map((currTime, i) => {
        const currShow = shows.find(show => show.id === currTime.id);
        const nextTime = sortedTimes[i + 1]

        if (nextTime && (currTime.starttime + currShow.duration) > nextTime.starttime) {
            const nextShow = shows.find(show => show.id === nextTime.id);

            throw new Error(`${currShow.title}, ${nextShow.title}`)
        }

        const hour = String(Math.floor(currTime.starttime / 60)).padStart(2, 0)
        const minute = String(currTime.starttime % 60).padStart(2, 0)

        const title = `<p class="title">${currShow.title}</p>`;
        const startTime = `${hour}:${minute}`
        const url = currShow.url

        return {
            title: title,
            starttime: startTime,
            url: url
        }
    })

    return sortedShows
}

export function getProgress(width, duration, current) {
    let progress = Math.round((current / duration) * width)

    if (isNaN(progress)) {
        progress = 0
    }

    if (current > duration) {
        progress = width
    }

    return progress
}