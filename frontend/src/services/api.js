const API_BASE_URL = "http://localhost:8080/api";
export async function fetchImages() {
  try {
    const response = await fetch(`${API_BASE_URL}/gallery`);
    if (!response.ok) throw new Error("Failed to fetch images");
    return await response.json();
  } catch (error) {
    console.error("Error fetching images:", error);
    throw error;
  }
}

export async function submitContactForm(formData) {
  try {
    const response = await fetch(`${API_BASE_URL}/contact`, {
      method: "POST",
      headers: {"Content-Type": "application/json"},
      body: JSON.stringify(formData),
    });
    if (!response.ok) throw new Error("Failed to send message");
    return await response.json();
  } catch (error) {
    console.error("Error submitting contact form", error);
    throw error;
  }
}
