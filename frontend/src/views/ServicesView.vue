<template>
  <div class="services">
    <h1> Photography Packages</h1>
    <div class="service-grid">
      <div v-for="service in services" :key="service.id" class="service-card">
        <h2>{{ service.name }}</h2>
        <p>{{ service.description }}</p>
        <p class="price">Price: {{ service.price }}</p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      services: [
        {id:1, name: "Basic Package", description: "Includes 10 high-quality photos with edits.", price: "$100"},
        {id:2, name: "Premium Package", description: "Includes 25 high-quality photos with edits.", price: "200"},
        {id:3, name: "Custom Package", description: "Tailor-made session for your needs.", price: "Contact for pricing"}
      ]
    };
  }
};
</script>

<style scoped>
.services {
  text-align: center;
  padding: 20px;
}

.service-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
  gap: 20px;
  margin-top: 20px;
}

.service-card {
  background: f4f4ff;
  padding: 20px;
  border-radius: 8px;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
}

.service-card h2 {
  margin-bottom: 10px;
}

.price {
  font-weight: bold;
  color: #333;
}
</style>
