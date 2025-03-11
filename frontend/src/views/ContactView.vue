<template>
  <div class="contact">
    <h1>Contact Me</h1>
    <form @submit.prevent="submitForm">
      <label for="name">Name:</label>
      <input type="text" id="name" v-model="form.name" @input="validateName" required />
      <p v-if="errors.name" class="error-message">{{ errors.name }}</p>

      <label for="email">Email:</label>
      <input type="text" id="email" v-model="form.email" @input="validateEmail" required />
      <p v-if="errors.email" class="error-message">{{ errors.email }}</p>

      <label for="message">Message:</label>
      <textarea id="message" v-model="form.message" @input="validateMessage" required />
      <p v-if="errors.message" class="error-message">{{ errors.message }}</p>

      <button type="submit" :disabled="hasErrors">Send</button>
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
      errors: {
        name: "",
        email: "",
        message: "",
      },
      submitted: false,
    };
  },
  computed: {
    hasErrors() {
      return this.errors.name || this.errors.email || this.errors.message;
    },
  },
  methods: {
    validateName() {
      if (this.form.name.length < 3) {
        this.errors.name = "Name must be at least 3 characters.";
      } else {
        this.errors.name="";
      }
    },
    validateEmail() {
      const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
      if (!emailPattern.test(this.form.email)) {
        this.errors.email = "Please enter a valid email address.";
      } else {
        this.errors.email = "";
      }
    },
    validateMessage() {
      if (this.form.message.length < 10) {
        this.errors.message = "Message must be at least 10 characters long.";
      } else {
        this.errors.message = "";
      }
    },
    submitForm() {
      this.validateName();
      this.validateEmail();
      this.validateMessage();
      if (!this.hasErrors) {
        console.log("Form Data: this.form");
        this.submitted = true;

        //Reset success message after a few seconds
        this.form.name = "";
        this.form.email = "";
        this.form.message = "";

          setTimeout(() => {
          this.submitted = false;
        }, 3000); //Clear form after submission
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
