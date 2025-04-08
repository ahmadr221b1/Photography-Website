<template>
  <div class="gallery">
    <h1>Photography Gallery</h1>
    <div v-if="loading">Loading images...</div>
    <div v-else-if="error">{{ error }}</div>
    <div v-else class="image-grid">
      <div v-for="image in images" :key="image.id" class="image-card">
        <img :src="image.url" :alt="image.alt" />
        <p>{{ image.alt }}</p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      images: [],
      loading: true,
      error: null
    };
  },
  async mounted() {
    try {
      const response = await fetch("http://localhost:8080/api/gallery");
      if (!response.ok) {
        throw new Error("Failed to fetch images");
      }
      this.images = await response.json();
    } catch (err) {
      this.error = err.message;
    } finally {
      this.loading = false;
    }
  },
};
</script>

<style scoped>
.gallery {
  text-align: center;
  padding: 20px;
}

.image-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
  gap: 20px;
  margin-top: 20px;
}

.image-card {
  background: #f4f4ff;
  padding: 10px;
  border-radius: 5px;
}

.image-card img {
  width: 100%;
  height: auto;
  border-radius: 5px;
}

.image-card p {
  margin-top: 10px;
  font-weight: bold;
}
</style>
