<template>
  <div class="gallery">
    <h1>Photography Gallery</h1>
    <div class="image-grid">
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
      images: [
        { id: 1, url: "images/photo1.jpg", alt: "Front of the House" },
        { id: 2, url: "images/photo2.jpg", alt: "Side angle view of the House" },
        { id: 3, url: "images/photo3.jpg", alt: "Side view of the House"}
      ],
    };
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
