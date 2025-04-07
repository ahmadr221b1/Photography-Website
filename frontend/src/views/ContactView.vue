<template>
  <div class="contact">
    <h1>Contact Me</h1>
    <form @submit.prevent="handleSubmit">
      <label for="name">Name:</label>
      <input type="text" id="name" v-model="form.name" @input="validateName" required />
      <p v-if="errors.name" class="error-message">{{ errors.name }}</p>

      <label for="email">Email:</label>
      <input type="text" id="email" v-model="form.email" @input="validateEmail" required />
      <p v-if="errors.email" class="error-message">{{ errors.email }}</p>

      <label for="message">Message:</label>
      <textarea id="message" v-model="form.message" @input="validateMessage" required />
      <p v-if="errors.message" class="error-message">{{ errors.message }}</p>

      <button type="submit" :disabled="hasErrors" @click="logFormData">Send</button>
    </form>
    <p v-if="submitted" class="success-message">Message Sent Successfully!</p>
    <p v-if="errorMessage" class="error-message">{{ errorMessage }}</p>
  </div>
</template>

<script>
import { submitContactForm } from "@/services/api.js";

export default {
  data() {
    return {
      form:{ name: "", email: "", message: ""},
      errors: { name: "", email: "", message: ""},
      submitted: false,
      errorMessage: "", //For API error messages
    };
  },
  mounted() {
    console.log("ContactView mounted ✅");
  },
  computed: {
    hasErrors() {
      return false;
    },
  },
  methods: {
    logFormData() {
      console.log('Form Data:', this.form);
    },
    validateName() {
      this.errors.name = this.form.name.length < 3 ? "Name must be at least 3 characters." : "";
    },
    validateEmail() {
      const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
      this.errors.email = !emailPattern.test(this.form.email) ? "Please enter a valid email address." : "";
    },
    validateMessage() {
      this.errors.message = this.form.message.length < 10 ? "Message must be at least 10 characters long." : "";
    },
    async submitForm() {
      if (this.hasErrors) return;

      try {
        await submitContactForm(this.form);
        this.submitted = true;
        this.form = { name: "", email: "", message: "" };
        this.errorMessage = ""; // Clear any previous errors

        setTimeout(() => (this.submitted = false), 3000);
      } catch (error) {
        console.error("Error:", error);
        this.errorMessage = "Failed to send message. Please try again later.";
      }
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
