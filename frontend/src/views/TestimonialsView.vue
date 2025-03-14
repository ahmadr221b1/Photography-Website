<template>
  <div class="testimonials">
    <h1>Client Testimonials</h1>
    <div class="testimonial-grid">
      <div v-for="testimonial in testimonials" :key="testimonial.id" class="testimonial-card">
        <p class="quote">"{{ testimonial.feedback }}"</p>
        <p class="client">- {{ testimonial.client }}</p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      testimonials: [
        { id: 1, client: "John Doe", feedback: "Amazing photography! The quality was outstanding, and the service was professional." },
        { id: 2, client: "Jane Smith", feedback: "Absolutely loved the photos. Highly recommended for any event!" },
        { id: 3, client: "Mike Johnson", feedback: "Captured the perfect moments. Thank you for the incredible work!" }
      ]
    };
  }
};
</script>

<style scoped>
.testimonials {
  text-align: center;
  padding: 20px;
}

.testimonial-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
  gap: 20px;
  margin-top: 20px;
}

.testimonial-card {
  background: #f4f4ff;
  padding: 15px;
  border-radius: 8px;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
}

.quote {
  font-style: italic;
  font-size: 16px;
  color: #333;
}

.client {
  font-weight: bold;
  margin-top: 10px;
  color: #555;
}
</style>
