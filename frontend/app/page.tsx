import { Navbar } from "@/components/layout/Navbar";
import { Footer } from "@/components/layout/Footer";
import { Hero } from "@/components/sections/Hero";

export default function Home() {
  return (
    <main className="min-h-screen bg-background text-foreground overflow-x-hidden">
      <Navbar />
      <Hero />
      <section className="py-20 bg-muted/30">
        <div className="container px-4 text-center">
          <h2 className="text-3xl font-bold mb-8">Why Choose Creative Gym?</h2>
          {/* Features Grid Placeholder */}
          <div className="grid grid-cols-1 md:grid-cols-3 gap-8">
            {['Expert Trainers', 'Modern Equipment', 'Flexible Classes'].map((feature) => (
              <div key={feature} className="p-6 rounded-2xl bg-card border shadow-sm hover:shadow-md transition-shadow">
                <h3 className="text-xl font-semibold mb-2">{feature}</h3>
                <p className="text-muted-foreground">Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
              </div>
            ))}
          </div>
        </div>
      </section>
      <Footer />
    </main>
  );
}
