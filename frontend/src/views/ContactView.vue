<template>
  <div class="contact">
    <h1>Contact Me</h1>
    <form @submit.prevent="submitForm">
      <label for="name">Name:</label>
      <input type="text" id="name" v-model="form.name" required />

      <label for="email">Email:</label>
      <input type="text" id="email" v-model="form.email" required />

      <label for="message">Message:</label>
      <textarea id="message" v-model="form.message" required />

      <button type="submit">Send</button>
    </form>
    <p v-if="submitted" class="success-message">Message Sent Successfully!</p>
  </div>
</template>

<script>
export default {
  data() {
    return {
      form: {
        name:"",
        email:"",
        message:"",
      },
      submitted: false,
    };
  },
  methods: {
    submitForm() {
      console.log("Form Data:", this.form);
      this.submitted = true;

      //Clear form after submission
      this.form.name = "";
      this.form.email = "";
      this.form.message = "";

      //Reset success message after a few seconds
      setTimeout(() => {
        this.submitted = false;
      }, 3000);
    },
  },
};
</script>

<style scoped>
.contact {
  max-width: 500px;
  margin: 20px auto;
  text-align: center;
}

form {
  display: flex;
  flex-direction: column;
  gap: 15px;
  background: #f4f4ff;
  padding: 20px;
  border-radius: 5px;
}

label {
  font-weight: bold;
}

input, textarea {
  width: 100%;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
}

button {
  background: #333;
  color: white;
  padding: 10px;
  border: none;
  cursor: pointer;
  border-radius: 5px;
}

button:hover {
  background: #555;
}

.success-message {
  color: green;
  font-weight: bold;
  margin-top: 10px;
}
</style>
