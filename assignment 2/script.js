document.addEventListener('DOMContentLoaded', function() {
    const currentDate = new Date();
    document.getElementById('current-date').innerText = currentDate.toDateString();

    const moreInfoBtn = document.getElementById('more-info-btn');
    const moreInfo = document.getElementById('more-info');

    moreInfoBtn.addEventListener('click', function() {
        moreInfo.classList.toggle('hidden');
        if (moreInfo.classList.contains('hidden')) {
            moreInfoBtn.innerText = 'Show More Info';
        } else {
            moreInfoBtn.innerText = 'Show Less Info';
        }
    });
});
