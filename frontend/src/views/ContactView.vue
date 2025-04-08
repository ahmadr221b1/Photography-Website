<template>
  <div class="contact">
    <h1>Contact Me</h1>
    <form @submit.prevent="submitForm">
      <label for="name">Name:</label>
      <input
        type="text"
        id="name"
        v-model="form.name"
        @input="validateName"
        required
      />
      <p v-if="touched.name && errors.name" class="error-message">
        {{ errors.name }}
      </p>

      <label for="email">Email:</label>
      <input
        type="text"
        id="email"
        v-model="form.email"
        @input="validateEmail"
        required
      />
      <p v-if="touched.email && errors.email" class="error-message">
        {{ errors.email }}
      </p>

      <label for="message">Message:</label>
      <textarea
        id="message"
        v-model="form.message"
        @input="validateMessage"
        required
      ></textarea>
      <p v-if="touched.message && errors.message" class="error-message">
        {{ errors.message }}
      </p>

      <button type="submit" :disabled="hasErrors">Send</button>
    </form>
    <p v-if="submitted" class="success-message">
      Message Sent Successfully!
    </p>
    <p v-if="errorMessage" class="error-message">{{ errorMessage }}</p>
  </div>
</template>

<script>
import { submitContactForm } from "@/services/api.js";

export default {
  data() {
    return {
      form: { name: "", email: "", message: "" },
      errors: { name: "", email: "", message: "" },
      touched: { name: false, email: false, message: false },
      submitted: false,
      errorMessage: ""
    };
  },
  computed: {
    hasErrors() {
      return !!(
        (this.touched.name && this.errors.name) ||
        (this.touched.email && this.errors.email) ||
        (this.touched.message && this.errors.message)
      );
    }
  },
  methods: {
    validateName() {
      this.touched.name = true;
      if (!this.form.name) {
        this.errors.name = "Name is required.";
      } else if (this.form.name.length < 3) {
        this.errors.name = "Name must be at least 3 characters.";
      } else {
        this.errors.name = "";
      }
      console.log("validateName:", this.form.name, this.errors.name);
    },
    validateEmail() {
      this.touched.email = true;
      const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
      if (!this.form.email) {
        this.errors.email = "Email is required.";
      } else if (!emailPattern.test(this.form.email)) {
        this.errors.email = "Please enter a valid email address.";
      } else {
        this.errors.email = "";
      }
      console.log("validateEmail:", this.form.email, this.errors.email);
    },
    validateMessage() {
      this.touched.message = true;
      if (!this.form.message) {
        this.errors.message = "Message is required.";
      } else if (this.form.message.length < 10) {
        this.errors.message = "Message must be at least 10 characters long.";
      } else {
        this.errors.message = "";
      }
      console.log("validateMessage:", this.form.message, this.errors.message);
    },
    async submitForm() {
      console.log("submitForm triggered", this.form, this.errors, this.touched);
      // Mark all fields as touched and run validations
      this.validateName();
      this.validateEmail();
      this.validateMessage();

      if (this.hasErrors) {
        console.log("Form has errors; not submitting:", this.errors);
        return;
      }
      try {
        console.log("Submitting contact form", this.form);
        await submitContactForm(this.form);
        this.submitted = true;
        this.errorMessage = "";
        // Clear the form and reset touched flags.
        this.form = { name: "", email: "", message: "" };
        this.touched = { name: false, email: false, message: false };

        setTimeout(() => {
          this.submitted = false;
        }, 3000);
      } catch (error) {
        console.error("Error submitting contact form:", error);
        this.errorMessage = "Failed to send message. Please try again later.";
      }
    }
  },
  mounted() {
    console.log("ContactView mounted ✅");
  }
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

input,
textarea {
  width: 100%;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
}

button {
  background: #333;
  color: white;
  padding: 10px 15px;
  border: none;
  cursor: pointer;
  border-radius: 5px;
  transition: background 0.3s ease;
}

button:hover {
  background: #555;
}

.success-message {
  color: green;
  font-weight: bold;
  margin-top: 10px;
}

.error-message {
  color: red;
  font-size: 0.9em;
}
</style>
