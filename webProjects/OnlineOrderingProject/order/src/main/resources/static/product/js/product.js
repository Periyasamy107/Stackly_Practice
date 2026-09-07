console.log("🔥 product.js is loaded!");
document.addEventListener("DOMContentLoaded", function () {
    console.log("🔥 DOMContentLoaded fired!");
    /*
     * Automatically remove success/error messages
     * after a few seconds.
     */
    const alerts = document.querySelectorAll(".alert");

    alerts.forEach(function (alert) {

        setTimeout(function () {

            alert.style.opacity = "0";
            alert.style.transform = "translateY(-5px)";

            setTimeout(function () {
                alert.remove();
            }, 250);

        }, 5000);

    });


    /*
     * Confirm status changes.
     */
    const statusForms =
        document.querySelectorAll(".status-form");

    statusForms.forEach(function (form) {

        form.addEventListener("submit", function (event) {

            const activeInput =
                form.querySelector("input[name='active']");

            if (!activeInput) {
                return;
            }

            const active =
                activeInput.value === "true";

            const message = active
                ? "Are you sure you want to activate this product?"
                : "Are you sure you want to deactivate this product?";

            if (!confirm(message)) {
                event.preventDefault();
            }

        });

    });

});
