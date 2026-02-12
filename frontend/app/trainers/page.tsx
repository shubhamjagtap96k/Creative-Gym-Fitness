"use client";

import { Navbar } from "@/components/layout/Navbar";
import { Footer } from "@/components/layout/Footer";
import { Avatar, AvatarImage, AvatarFallback } from "@/components/ui/avatar";
import { Button } from "@/components/ui/button";
import { motion } from "framer-motion";
import { Instagram, Twitter } from "lucide-react";

const trainers = [
    {
        id: 1,
        name: "Alex Johnson",
        specialty: "Strength & Conditioning",
        bio: "Certified NSCA trainer with 5 years of experience in powerlifting and athletic performance.",
        image: "https://images.unsplash.com/photo-1571019614242-c5c5dee9f50b?w=400&h=400&fit=crop",
    },
    {
        id: 2,
        name: "Sarah Lee",
        specialty: "Yoga & Mobility",
        bio: "RYT-200 Yoga Instructor focusing on functional mobility and injury prevention.",
        image: "https://images.unsplash.com/photo-1548690312-e3b507d8c110?w=400&h=400&fit=crop",
    },
    {
        id: 3,
        name: "Mike Chen",
        specialty: "HIIT & Cardio",
        bio: "Former track athlete specialized in high-intensity interval training for fat loss.",
        image: "https://images.unsplash.com/photo-1568602471122-7832951cc4c5?w=400&h=400&fit=crop",
    },
];

export default function TrainersPage() {
    return (
        <main className="min-h-screen bg-background">
            <Navbar />

            <section className="pt-32 pb-20 px-4">
                <div className="container mx-auto text-center mb-16">
                    <h1 className="text-4xl md:text-6xl font-bold mb-6">
                        Meet the <span className="text-primary">Experts</span>
                    </h1>
                    <p className="text-xl text-muted-foreground max-w-2xl mx-auto">
                        Our certified trainers are here to guide, motivate, and push you to your limits.
                    </p>
                </div>

                <div className="container mx-auto grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-8 max-w-6xl">
                    {trainers.map((trainer, index) => (
                        <motion.div
                            key={trainer.id}
                            initial={{ opacity: 0, scale: 0.9 }}
                            animate={{ opacity: 1, scale: 1 }}
                            transition={{ delay: index * 0.1 }}
                            className="group relative bg-card rounded-2xl overflow-hidden border hover:border-primary/50 transition-all duration-300 hover:shadow-2xl hover:shadow-primary/10"
                        >
                            <div className="aspect-square overflow-hidden bg-muted relative">
                                <img
                                    src={trainer.image}
                                    alt={trainer.name}
                                    className="object-cover w-full h-full group-hover:scale-105 transition-transform duration-500"
                                />
                                <div className="absolute inset-0 bg-gradient-to-t from-black/80 via-transparent to-transparent opacity-0 group-hover:opacity-100 transition-opacity duration-300 flex items-end p-6">
                                    <div className="flex gap-4">
                                        <Button size="icon" variant="ghost" className="text-white hover:text-primary hover:bg-white/10">
                                            <Instagram className="w-5 h-5" />
                                        </Button>
                                        <Button size="icon" variant="ghost" className="text-white hover:text-sky-400 hover:bg-white/10">
                                            <Twitter className="w-5 h-5" />
                                        </Button>
                                    </div>
                                </div>
                            </div>

                            <div className="p-6">
                                <h3 className="text-2xl font-bold mb-1">{trainer.name}</h3>
                                <p className="text-primary font-medium mb-3">{trainer.specialty}</p>
                                <p className="text-muted-foreground text-sm leading-relaxed">
                                    {trainer.bio}
                                </p>
                            </div>
                        </motion.div>
                    ))}
                </div>
            </section>

            <Footer />
        </main>
    );
}
