<!DOCTYPE html>
<html>
<head>
    <title>Book a Service</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <script src="https://maps.googleapis.com/maps/api/js?key=YOUR_GOOGLE_MAPS_API_KEY&callback=initMap" async defer></script>
    <script>
        function initMap() {
            const map = new google.maps.Map(document.getElementById("map"), {
                zoom: 12,
                center: { lat: 13.0827, lng: 80.2707 } // Chennai default
            });

            const marker = new google.maps.Marker({
                position: { lat: 13.0827, lng: 80.2707 },
                map: map,
                draggable: true
            });

            marker.addListener('dragend', function () {
                document.getElementById('latitude').value = marker.getPosition().lat();
                document.getElementById('longitude').value = marker.getPosition().lng();
            });
        }
    </script>
</head>
<body class="p-4">
    <h2>Book Your Car Wash</h2>
    <form action="book" method="post">
        <div class="mb-3"><label>Name</label><input type="text" name="name" class="form-control" required></div>
        <div class="mb-3"><label>Phone</label><input type="text" name="phone" class="form-control" required></div>
        <div class="mb-3"><label>Email</label><input type="email" name="email" class="form-control"></div>
        <div class="mb-3"><label>Location Address</label><textarea name="location" class="form-control" required></textarea></div>
        <div id="map" style="height:300px;width:100%;"></div>
        <input type="hidden" id="latitude" name="latitude">
        <input type="hidden" id="longitude" name="longitude">
        <div class="mb-3">
            <label>Service</label>
            <select name="service" class="form-control" required>
                <option value="Exterior Wash">Exterior Wash</option>
                <option value="Interior Cleaning">Interior Cleaning</option>
                <option value="Full Detailing">Full Detailing</option>
            </select>
        </div>
        <button type="submit" class="btn btn-success">Submit</button>
    </form>
</body>
</html>
